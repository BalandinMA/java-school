package enums;

import lombok.AllArgsConstructor;

/**
 * @author Evgeny Borisov
 */
public enum  MaritalStatus {
    SINGLE(1,"холост"),
    MARRIED(2,"жената"),
    DIVORCED(3,"разведена");

    private final int dbCode;

    private final String russDesc;

    MaritalStatus(int dbCode, String russDesc) {
        this.dbCode = dbCode;
        this.russDesc = russDesc;
    }

    public static MaritalStatus findByDbCode(int dbCode) {
        MaritalStatus[] statuses = values();

        for (MaritalStatus status : statuses) {
            if (status.dbCode == dbCode) {
                return status;
            }
        }
        throw new UnsupportedOperationException(dbCode + " not supported yet");
    }




}




