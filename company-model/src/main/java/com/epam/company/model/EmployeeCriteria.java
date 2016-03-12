package com.epam.company.model;


public class EmployeeCriteria {

    private Long departmentId;
    private String firstName;
    private String lastName;
    private String location;
    private String email;
    private Integer skip;
    private Integer limit;

    public EmployeeCriteria(Long departmentId, String firstName, String lastName, String location, String email, Integer skip, Integer limit) {
        this.departmentId = departmentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.email = email;
        this.skip = skip;
        this.limit = limit;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public Integer getSkip() {
        return skip;
    }

    public Integer getLimit() {
        return limit;
    }

    public static class Builder {

        private Long departmentId;
        private String firstName;
        private String lastName;
        private String location;
        private String email;
        private Integer skip;
        private Integer limit;

        public Builder departmentId(final Long departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder location(final String location) {
            this.location = location;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder skip(final Integer skip) {
            this.skip = skip;
            return this;
        }

        public Builder limit(final Integer limit) {
            this.limit = limit;
            return this;
        }

        public EmployeeCriteria build() {
            return new EmployeeCriteria(departmentId, firstName, lastName, location, email, skip, limit);
        }
    }

}
