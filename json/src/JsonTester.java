import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.jsonext.stu.entity.Student;

public class JsonTester {

    /**
     * @date Jan 20, 2008
     * @author linlinyu
     * @param args
     */
    public static void main(String[] args) {

        Student stu = new Student();
        stu.setId(1);
        stu.setAge(20);
        stu.setName("linlinyu");
        JSONObject json = JSONObject.fromObject(stu);
        System.out.println(json);// {"id":1,"name":"linlinyu","age":20}

        String jsonText = "{name:\"WangXin\", students:{\"id\":1,\"name\":\"linlinyu\",\"age\":20}}";
        JSONObject teacherJson = new JSONObject();

        System.out.println(json.fromObject(jsonText));

        System.out.println(dellJson());
    }

    public static String dellJson() {

        String str = "";
        Map<String, Address> addressMap = new HashMap<String, Address>();
        Address maryLebow = new Address("5 Main Street", "San Diego, CA", "91912", "619-332-3452", "664-223-4667");
        addressMap.put("Mary Lebow", maryLebow);

        Address amySmith = new Address("25 H Street", "Los Angeles, CA", "95212", "660-332-3452", "541-223-4667");
        addressMap.put("Sally May", amySmith);

        Address johnKim = new Address("2343 Sugarland Drive", "Houston, TX", "55212", "554-332-3412", "461-223-4667");
        addressMap.put("John Kim", johnKim);

        Address richardThorn = new Address("14 68th Street", "New York, NY", "12452", "212-132-6182", "161-923-4001");
        addressMap.put("Richard Thorn", richardThorn);

        JSONArray jsonArrayAddresses = new JSONArray();
        for (Entry<String, Address> e : addressMap.entrySet()) {
            String addrName = e.getKey();
            Address addr = e.getValue();

            try {
                JSONObject jsonAddressDetail = new JSONObject();
                jsonAddressDetail.put("street", addr.getStreet());
                jsonAddressDetail.put("city", addr.getCity());
                jsonAddressDetail.put("zip", addr.getZip());

                JSONArray jsonArrayPhones = new JSONArray();
                jsonArrayPhones.add(addr.getPhoneNumber1());
                jsonArrayPhones.add(addr.getPhoneNumber2());

                JSONObject jsonAddress = new JSONObject();
                jsonAddress.put("name", addrName);
                jsonAddress.put("address", jsonAddressDetail);
                jsonAddress.put("phoneNumbers", jsonArrayPhones);

                jsonArrayAddresses.add(jsonAddress);

            } catch (JSONException a) {
                a.printStackTrace();
            }

        }
        try {
            System.out.println(jsonArrayAddresses);
            str = new JSONObject().put("addressbood", jsonArrayAddresses).toString();
        } catch (JSONException a) {
            a.printStackTrace();
        }

        return str;
    }
}
