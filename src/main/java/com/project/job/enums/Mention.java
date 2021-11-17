package com.project.job.enums;

import lombok.Getter;
@Getter
public enum Mention {

    PASSABLE("Passable"),
    ASSEZBIEN("Assez Bien"),
    BIEN("Bien"),
    TRESBIEN("Très Bien");



    String name;

    Mention (String name) {
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
                for (com.project.job.enums.Mention values : com.project.job.enums.Mention.values()) {
                    if (type.equalsIgnoreCase(values.getName())) {
                        return true;
                    }
                }
            }
            return false;
        }

}

