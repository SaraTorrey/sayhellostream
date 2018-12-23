package com.sayhellostream.sayhellostream;

import com.sayhellostream.sayhellostream.domain.AppUser;
import com.sayhellostream.sayhellostream.domain.Company;
import com.sayhellostream.sayhellostream.domain.LessonDay;
import com.sayhellostream.sayhellostream.domain.LessonType;
import com.sayhellostream.sayhellostream.domain.Payment;
import com.sayhellostream.sayhellostream.domain.PaymentType;
import com.sayhellostream.sayhellostream.domain.Student;
import com.sayhellostream.sayhellostream.domain.UserRoleType;
import com.sayhellostream.sayhellostream.repo.CompanyRepo;
import com.sayhellostream.sayhellostream.repo.GuardianRepo;
import com.sayhellostream.sayhellostream.repo.StudentRepo;
import com.sayhellostream.sayhellostream.repo.UserRepo;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import java.math.BigDecimal;

@SpringBootApplication
public class SendafoxApplication {


	@Autowired
	CompanyRepo companyRepo;

	@Autowired
	StudentRepo studentRepo;

	@Autowired
	GuardianRepo guardianRepo;

	@Autowired
	UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(SendafoxApplication.class, args);
	}

	@PostConstruct
	@Transactional
	public void loadData() {

		Company company = new Company();
		company.setName( "Houston Voice and Piano" );
		companyRepo.save( company );
		loadDataForCompany( company );


		createUser( "dan", "dan", "Dan", "Torrey", "danielowentorrey@gmail.com", company );

		Company company2 = new Company();
		company2.setName( "Company 2" );
		companyRepo.save( company2 );
//        loadDataForCompany( company2 );
		createUser( "sara", "sara", "Sara", "Torrey", "sara.moravej@gmail.com", company2 );
		createUser( "owen", "owen", "Oweny", "Torrey", "owen.torrey@gmail.com", company2 );

	}

	private void createUser( String username,
							 String password,
							 String firstName,
							 String lastName,
							 String email,
							 Company company ) {

		AppUser user = new AppUser();
		user.setUsername( username );
		user.setFirstName( firstName );
		user.setLastName( lastName );
		user.setEmail( email );
		user.setCompany( company );
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = bCryptPasswordEncoder.encode( password );
		user.setPassword( encodedPassword );
		user.setRole(UserRoleType.ADMIN );
		userRepo.save( user );
	}

	private void loadDataForCompany( Company company ) {

		Student student = new Student("Dan", "Torrey", "Monday 5pm", company );
		student.setLessonType(LessonType.VOICE );
		student.setLessonDay(LessonDay.MONDAY );
		student.setLessonTime( new org.joda.time.LocalTime( 14, 0, 0, 0 ) );
		
		Payment payment = new Payment();
		payment.setDate(LocalDate.now() );
		payment.setAmount(Money.of(CurrencyUnit.USD, BigDecimal.TEN ) );
		payment.setType(PaymentType.CASH );
		payment.setStudent( student );
		student.getPayments().add( payment );

		payment = new Payment();
		payment.setDate( LocalDate.now().minusDays( 90 ) );
		payment.setAmount( Money.of( CurrencyUnit.USD, BigDecimal.ONE ) );
		payment.setType( PaymentType.CHECK );
		payment.setStudent( student );
		student.getPayments().add( payment );

		payment = new Payment();
		payment.setDate( LocalDate.now().minusDays( 90 ) );
		payment.setAmount( Money.of( CurrencyUnit.USD, new BigDecimal( "25" ) ) );
		payment.setType( PaymentType.CHECK );
		payment.setStudent( student );
		student.getPayments().add( payment );

		studentRepo.save( student );
		studentRepo.save( new Student( "Sara", "Torrey", "Monday 3pm", company ) );
		studentRepo.save( new Student( "Nino", "Torrey", "Wednesday 4pm", company ) );
		studentRepo.save( new Student( "Owen", "Torrey", "Monday 1pm", company ) );
		studentRepo.save( new Student( "Cameron", "Torrey", "Monday 2pm", company ) );

	}
}

