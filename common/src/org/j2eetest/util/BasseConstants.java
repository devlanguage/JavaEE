package org.j2eetest.util;

public class BasseConstants {
    public final static String TABLE_TMFNBI_CONFIG_TYPE_NBI_NOTIFICATION_LISTENER = "NBI_NOTIFICATION_LISTENER";
    public final static String TABLE_TMFNBI_CONFIG_TYPE_NBI_SYNCHRONIZER = "NBI_SYNCHRONIZER";
    public final static String TABLE_TMFNBI_CONFIG_TYPE_NBI_CONFIG_INFO = "NBI_CONFIG_INFO";
    public final static long MESSAGE_HEART_BEAT_INTERVAL = 5000;
    
    public final static String NS_TMF854_TYPES = "http://tellabs.tmf854.v1";
    public final static String NS_TMF854_SERVICES = "http://tellabs.tmf854.v1/ws";
    
    public final static String EMS_NAME ="Tellabs/T7100EMS";
    public final static String EMS_DEFAULT_MD_NAME ="Tellabs/T7100EMS";
    public final static String EMS_DEFAULT_MLSN_NAME ="Tellabs/T7100EMS";
    public final static String EMS_DOMAIN = "Tellabs";
    public final static String EMS_MANUFACTURE = "Tellabs";
    public final static String EMS_NAMING_OS = "T7100EMS";
    public final static String EMS_OWNER = "T7100EMS";    
    public final static String EMS_SOURCE = "networkEMS";
    public final static String EMS_TYPE = "EMS"; //EMS, SNMS, EMS/SNMS
    public final static String EMS_MAX_ALARM_LEVEL = "FATAL";    

    public final static String MTOSI_EXT_AUTHOR = "Tellabs";
    public final static String MTOSI_EXT_VERSION = "2.0";
    public final static String MTOSI_TMF854_VERSION = "1.1";

    public final static String DEFAULT_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
    public final static String GMT_DATE_FORMAT="yyyyMMddHHmmss.SSS";
    public final static String ITU_DATE_FORMAT_NO_TIME_ZONE="yyyyMMddHHmmss.SSSSS";//yyyyMMddhhmmss.s[Z|{+|-}HHMm]  //19851106210627.3+0500
    public final static String ITU_DATE_FORMAT_WITH_TIME_ZONE="yyyyMMddHHmmss.SSSSSZ";
        
    public final static String DIRTY_DATA_IGNORE = "DIRTY_DATA_IGNORE";

    // Opitical Card
    public final static String CARD_TYPE_LIAM = "LIAM";
    public final static String CARD_TYPE_LIAME = "LIAME";
    public final static String CARD_TYPE_LRAM = "LRAM";
    public final static String CARD_TYPE_LRAME = "LRAME";
    public final static String CARD_TYPE_ELRAME = "ELRAME";
    public final static String CARD_TYPE_LOAM = "LOAM";
    public final static String CARD_TYPE_LOAME = "LOAME";
    public final static String CARD_TYPE_RCMM = "RCMM";
    public final static String CARD_TYPE_RCMMS = "RCMMS";
    public final static String CARD_TYPE_CMM44 = "CMM44";
    public final static String CARD_TYPE_RCMMS44 = "RCMMS44";
    public final static String CARD_TYPE_CCMIR = "CCMIR";
    public final static String CARD_TYPE_CCMLR = "CCMLR";
    public final static String CARD_TYPE_OLAIR = "OLAIR";
    public final static String CARD_TYPE_OLALR = "OLALR";
    public final static String CARD_TYPE_CCM = "CCM";
    public final static String CARD_TYPE_OADM = "OADM";
    public final static String CARD_TYPE_OTSM = "OTSM";
    public final static String CARD_TYPE_OMD = "OMD";
    // Control Card
    public final static String CARD_TYPE_AIM = "AIM";
    public final static String CARD_TYPE_CPM = "CPM";
    // Packet Card
    public final static String CARD_TYPE_SMTMP = "SMTMP";
    public final static String CARD_TYPE_TGIMP = "TGIMP";
    // SONET/SDH Card
    public final static String CARD_TYPE_FGTM = "FGTM";
    public final static String CARD_TYPE_MRTME = "MRTME";
    public final static String CARD_TYPE_MRTMS = "MRTMS";
    public final static String CARD_TYPE_MRTMT = "MRTMT";
    public final static String CARD_TYPE_TGTME = "TGTME";
    public final static String CARD_TYPE_TGTMT = "TGTMT";
    public final static String CARD_TYPE_OPSM = "OPSM";
    public final static String CARD_TYPE_FGTMM = "FGTMM";
    public final static String CARD_TYPE_HDTG = "HDTG";
    public final static String CARD_TYPE_OTNMD = "OTNMD";
    public final static String CARD_TYPE_OTNMX = "OTNMX";
    public final static String CARD_TYPE_SMTMU = "SMTMU";
    public final static String CARD_TYPE_SMTMUD = "SMTMUD";
    public final static String CARD_TYPE_SMTMSD = "SMTMSD";
    public final static String CARD_TYPE_SSMD = "SSMD";
    public final static String CARD_TYPE_SSMX = "SSMX";

    public final static String FAC_TYPE_UNDEFINED_ENTITY = "TELLABS_UNDEFINED_ENTITY";
    public final static String FAC_TYPE_OTS = "OTS";
    public final static String FAC_TYPE_OMS = "OMS";
    public final static String FAC_TYPE_OSC = "OSC";
    public final static String FAC_TYPE_OSCX = "OSCX";
    public final static String FAC_TYPE_OCH = "OCH";
    public final static String FAC_TYPE_OCH_L = "OCH-L";
    public final static String FAC_TYPE_OCH_P = "OCH-P";
    public final static String FAC_TYPE_OCH_DP = "OCH-DP";
    public final static String FAC_TYPE_OC768 = "OC768";
    public final static String FAC_TYPE_OC192 = "OC192";
    public final static String FAC_TYPE_OC48 = "OC48";
    public final static String FAC_TYPE_OC12 = "OC12";
    public final static String FAC_TYPE_OC3 = "OC3";
    public final static String FAC_TYPE_STM256 = "STM256";
    public final static String FAC_TYPE_STM64 = "STM64";
    public final static String FAC_TYPE_STM16 = "STM16";
    public final static String FAC_TYPE_STM4 = "STM4";
    public final static String FAC_TYPE_STM1 = "STM1";
    public final static String FAC_TYPE_TGFC = "TGFC";
    public final static String FAC_TYPE_TGLAN = "TGLAN";
    public final static String FAC_TYPE_TGBEP = "TGBEP";
    public final static String FAC_TYPE_GBEP = "GBEP";
    public final static String FAC_TYPE_OPTD = "OPTD";
    public final static String FAC_TYPE_ODU1_C = "ODU1-C";
    public final static String FAC_TYPE_ODU1 = "ODU1";
    public final static String FAC_TYPE_ODU2 = "ODU2";
    public final static String FAC_TYPE_ODU3 = "ODU3";
    public final static String FAC_TYPE_OTU1 = "OTU1";
    public final static String FAC_TYPE_OTU2 = "OTU2";
    public final static String FAC_TYPE_OTU3 = "OTU3";
    public final static String FAC_TYPE_GOPT = "GOPT";
    public final static String FAC_TYPE_GOPT_W = "GOPT-W";
    public final static String FAC_TYPE_GOPT_P = "GOPT-P";
    public final static String FAC_TYPE_STS1 = "STS1";
    public final static String FAC_TYPE_STS3C = "STS3C";
    public final static String FAC_TYPE_STS3T = "STS3T";
    public final static String FAC_TYPE_STS12C = "STS12C";
    public final static String FAC_TYPE_STS12T = "STS12T";
    public final static String FAC_TYPE_STS48C = "STS48C";
    public final static String FAC_TYPE_STS48T = "STS48T";
    public final static String FAC_TYPE_VC3 = "VC3";
    public final static String FAC_TYPE_VC4 = "VC4";
    public final static String FAC_TYPE_STM1T = "STM1T";
    public final static String FAC_TYPE_VC44C = "VC43C";
    public final static String FAC_TYPE_STM4T = "STM4T";
    public final static String FAC_TYPE_VC416C = "VC416C";
    public final static String FAC_TYPE_STM16T = "STM16T";
    public final static String FAC_TYPE_VC464C = "VC464C";
    public final static String FAC_TYPE_STS1CNV = "STS1CNV";
    public final static String FAC_TYPE_STS3CNV = "STS3CNV";
    public final static String FAC_TYPE_VC3NV = "VC3NV";
    public final static String FAC_TYPE_VC4NV = "VC4NV";
    public final static String FAC_TYPE_TTP = "TTP";
    public final static String FAC_TYPE_TTPGROUP = "TTPGROUP";
    public final static String FAC_TYPE_TTPVC3 = "TTPVC3";
    public final static String FAC_TYPE_TTPVC4 = "TTPVC4";
    public final static String FAC_TYPE_TTPSTS1 = "TTPSTS1";
    public final static String FAC_TYPE_TTPSTS3C = "TTPSTS3C";

    public final static String FAC_TYPE_HDTG_PTP = "HDTG_PTP";
    
    public final static String FAC_TYPE_EQPT = "EQPT";
    public final static String FAC_TYPE_EMS = "EMS";
    public final static String FAC_TYPE_FAC = "FAC";
    public final static String FAC_TYPE_COM = "COM";
    public final static String FAC_TYPE_DB = "DB";
    public final static String FAC_TYPE_NTPEER = "NTPEER";
    public final static String FAC_TYPE_ROUTER = "ROUTER";
    public final static String FAC_TYPE_DHCP = "DHCP";
    public final static String FAC_TYPE_SW = "SW";
    public final static String FAC_TYPE_CERT = "CERT";
    public final static String FAC_TYPE_LAPDS = "LAPDS";
    public final static String FAC_TYPE_LAPDL = "LAPDL";
    public final static String FAC_TYPE_OSIRTR = "OSIRTR";
    public final static String FAC_TYPE_SESSION = "SESSION";
    public final static String FAC_TYPE_ENV = "ENV";
    public final static String FAC_TYPE_BKUP = "BKUP";
    public final static String FAC_TYPE_FXFR = "FXFR";

    public final static String BOOLEAN_FALSE = "FALSE";
    public final static String BOOLEAN_TRUE = "TRUE";

    public final static String SET_TP_PARAM_TL1_FACILITY_TYPE = "TL1FacilityType";
    public final static String SET_TP_PARAM_ALLOCATED_FOR_VCAT = "AllocatedForVCAT";
    public final static String SET_TP_PARAM_EDITABLE_PRIMARY_STATE = "editablePrimaryState";

    public final static String TP_NO_SIDE = "NO_SIDE";
    public final static String TP_LINE_SIDE = "LINE_SIDE";
    public final static String TP_PORT_SIDE = "PORT_SIDE";
    public final static String TP_DEFAULT_CONN_STATE = "TPCS_NA";
    public final static String TP_DEFAULT_TERMINATION_MODE = "TM_NA";

    public final static String STRING_DELIMITER_AID = "-";
    public final static String STRING_DELIMETER_LAYER_RATE = "/";
    public final static String STRING_DELIMITER_STSMAP = "&";
    public final static String STRING_DELIMITER_SPACE = " ";
    public final static String STRING_DELIMITER_THREE_BAR = "|||";
    public final static String STRING_DELIMITER_SHARP = "#@#";
    public final static String STRING_DELIMITER_AT = "@";
    public final static String STRING_DELIMITER_COLON = ":";
    public final static String STRING_DELIMITER_COMMA = ",";
    public final static String STRING_DELIMITER_EQUAL = "=";


    public final static String NBI_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss SSSSS";

    public final static String SNC_DIRECTION_BI = "CD_BI";
    public final static String SNC_DIRECTION_UNI = "CD_UNI";

    public final static String CONFIG_FILE_NBI_CONFIG = "nbi_config.conf";
    public final static String CONFIG_FILE_TMF814_CLIENT_CONFIG = "TMF814Client.conf";
    public final static String CONFIG_FILE_WS_CLIENT_CONFIG = "wsclient.properties";
    public final static String CONFIG_FILE_SNMP_CLIENT_CONFIG = "SNMPClient.conf";
    public final static String CONFIG_FILE_NOTIF_COFNIG = "Creation_Deletion_Notif_Configuration.pm";
    public final static String CONFIG_FILE_NBI_ADMIN_COMMAND = "nbi_admin_command.xml";
    public final static String CONFIG_FILE_LAYER_RATE = "ne_layerrate.xml";
    
}
