package com.project.job.enums;

import lombok.Getter;

/**
 * Enumrates the possible types for "Users".
 *
 * @author Elhem Nouri
 */
@Getter
public enum UsersType {

    ADMIN("Admin"),
    RECRUTEUR("Recruteur"),
    DEMANDEUR("Demandeur");


    String name;

    UsersType (String name) {
        this.name = name;
    }


    /**
     * Checks if the given type exist.
     *
     * @param type the given type
     * @return {@code true} if the type is supported, {@code false} if not or if the input is
     * {@code null}
     */
    public static boolean contains(String type)
    {
        if (type != null) {
            for (UsersType values : UsersType.values()) {
                if (type.equalsIgnoreCase(values.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

}

