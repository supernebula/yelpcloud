package clone;

import com.evol.domain.dto.BusinessDTO;
import com.evol.domain.model.Business;
import org.junit.Test;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

public class BeanCopierTest {

//    @Test
//    public void CopyTest(){
//        ArrayList<Business> list = new ArrayList<>();
//        Business b1 = new Business();
//        b1.setId("1");
//        b1.setCity("abcd");
//
//        Business b2 = new Business();
//        b1.setId("2");
//        b1.setCity("eeee");
//
//        list.add(b1);
//
//        BeanCopier copier = BeanCopier.create(Business.class, BusinessDTO.class, false);
//
//        ArrayList<BusinessDTO> dtoList = new ArrayList<>();
//
//        //copier.copy(list, dtoList);
//
//
//
//
//    }
}
