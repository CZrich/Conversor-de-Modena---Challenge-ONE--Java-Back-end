package dto;

import java.util.List;

public record CodesDto(String result, String documentation,
                       String terms_of_use, List<List<String>> supported_codes) {
}
