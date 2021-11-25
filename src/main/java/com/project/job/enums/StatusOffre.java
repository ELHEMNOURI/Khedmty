package com.project.job.enums;

import lombok.Getter;

@Getter
public enum StatusOffre {

    VALIDER("Valider"),
    INVALIDE("Invalide"),
    ENATTENTE("En_Attente");



    String name;

    StatusOffre(String name) {
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
                for (StatusOffre values : StatusOffre.values()) {
                    if (type.equalsIgnoreCase(values.getName())) {
                        return true;
                    }
                }
            }
            return false;
        }

}

