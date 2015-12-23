package org.cxftest.user.vo;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IntegerUserMapAdapter extends XmlAdapter<IntegerUserMap, Map<Integer, UserVo>> {

    public IntegerUserMap marshal(Map<Integer, UserVo> v) throws Exception {

        IntegerUserMap map = new IntegerUserMap();
        for (Map.Entry<Integer, UserVo> e : v.entrySet()) {
            IntegerUserMap.IntegerUserEntry iue = new IntegerUserMap.IntegerUserEntry();
            iue.setUser(e.getValue());
            iue.setId(e.getKey());
            map.getEntries().add(iue);
        }
        return map;
    }

    public Map<Integer, UserVo> unmarshal(IntegerUserMap v) throws Exception {

        Map<Integer, UserVo> map = new LinkedHashMap<Integer, UserVo>();
        for (IntegerUserMap.IntegerUserEntry e : v.getEntries()) {
            map.put(e.getId(), e.getUser());
        }
        return map;
    }

}
