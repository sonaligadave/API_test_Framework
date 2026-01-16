package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {
    Faker faker;
    User userPayload;

    @BeforeClass
    public void setupDate() {
        faker = new Faker();
        userPayload = new User();
        userPayload.setUsername(faker.name().username());
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setFirstName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5, 10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());
    }

    @Test(priority = 1)
    public void testPostUser(){
       Response response = UserEndPoints.createUser(userPayload);
       assert response.statusCode() == 200;
       response.then().log().all();
    }
}
