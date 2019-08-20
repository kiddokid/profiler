import com.example.profiler.encryption.CryptographicHashService
import com.example.profiler.encryption.EncryptionService
import spock.lang.Specification
import spock.lang.Unroll

class CryptographicHashServiceTest extends Specification {

    private EncryptionService cryptographicHashService = new CryptographicHashService()

    @Unroll
    def "service encryption works"() {
        setup:
        String result

        when:
        result =  cryptographicHashService.hash("123456789 abc")

        then:
        assert result == "8061268a5a4d904b19169f6251f5198e78028cf9855e2e1bd0d17c8950b3d92c"

        when:
        result = cryptographicHashService.hash("123456789 abc")

        then:
        assert result == "8061268a5a4d904b19169f6251f5198e78028cf9855e2e1bd0d17c8950b3d92c"

        when:
        long startTime = System.currentTimeMillis();
        result = cryptographicHashService.hash("{\n" +
                "  \"test\": {\n" +
                "    \"take\": {\n" +
                "      \"hundred\": -1297188882.0350928,\n" +
                "      \"year\": -2007242086.316349,\n" +
                "      \"shelf\": 1743084176.4973187,\n" +
                "      \"whether\": 1642545210,\n" +
                "      \"threw\": \"rope\",\n" +
                "      \"return\": \"was\"\n" +
                "    },\n" +
                "    \"shall\": true,\n" +
                "    \"wise\": \"herd\",\n" +
                "    \"observe\": true,\n" +
                "    \"mother\": \"post\",\n" +
                "    \"film\": -1976016521\n" +
                "  },\n" +
                "  \"engine\": 671683562,\n" +
                "  \"driven\": \"stiff\",\n" +
                "  \"pride\": true,\n" +
                "  \"double\": \"beginning\",\n" +
                "  \"lips\": 1414015053\n" +
                "}")
        long elapsedTime = System.currentTimeMillis() - startTime

        then:
        assert result == "e2f35e728a54b83e8f74c494f390548da0a2276439f3be8483660684dd69cdb1"
        assert elapsedTime < 100
    }
}
