package app.validation;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.when;


//@RunWith(SpringRunner.class) //@RunWith from JUnit4 was replaced bye JUnit5 @ExtendWith
@ExtendWith(SpringExtension.class)
class ValidServiceTest {

    @InjectMocks
    private ValidService injectMockValidService;

    @Mock
    private ValidRepo mockValidRepo;

    private List<ValidOb> testCasesList;
    private List returnedLMiddleSumList;

    private void setUpTestRepo(){
        ValidOb validOb1 = new ValidOb(1,"test1",1,4);
        ValidOb validOb2 = new ValidOb(2,"test2",3,3);
        ValidOb validOb3 = new ValidOb(3,"test3",7,2);
        testCasesList = Arrays.asList(validOb1,validOb2,validOb3);

        ValidOb concatenatedObject= new ValidOb(6,"_x_test1_x_test2_x_test3",11,9);
        returnedLMiddleSumList = new LinkedList();
        returnedLMiddleSumList.addAll(testCasesList);
        returnedLMiddleSumList.add(concatenatedObject);
    }

    @Test
    public void connectCurrentPrevNextEntity() {
        //given
        setUpTestRepo();
        when(mockValidRepo.findAllByOrderById()).thenReturn(testCasesList);

        Assert.assertEquals(returnedLMiddleSumList,injectMockValidService.connectCurrentPrevNextEntity(2));
    }
}