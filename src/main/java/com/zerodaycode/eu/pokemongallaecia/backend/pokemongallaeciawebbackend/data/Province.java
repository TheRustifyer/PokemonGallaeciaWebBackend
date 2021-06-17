package com.zerodaycode.eu.pokemongallaecia.backend.pokemongallaeciawebbackend.data;

public enum Province {
    A_CORUÑA,
    LUGO,
    PONTEVEDRA,
    OURENSE;

    /// Converts the enum's constant identifier to a url param format
    public String toUrl() {
        // Initializes a variable to store the final formatted url
        StringBuilder cityUrl = new StringBuilder();

        String[] enumNameWords = super.toString().split("_");

        for (int i = 0; i < enumNameWords.length; i++) {
            cityUrl.append(enumNameWords[i].toLowerCase());

            if (i < enumNameWords.length - 1) {
                cityUrl.append("%20");
            }
        }
        
        return cityUrl.toString();
    }
}
