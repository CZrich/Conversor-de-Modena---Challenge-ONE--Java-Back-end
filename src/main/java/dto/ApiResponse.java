package dto;

import java.util.List;

public class ApiResponse {
    private String result;
    private String documentation;
    private String terms_of_use;
    private List<List<String>> supported_codes;

    // Getters
    public List<List<String>> getSupportedCodes() {
        return supported_codes;
    }
}
