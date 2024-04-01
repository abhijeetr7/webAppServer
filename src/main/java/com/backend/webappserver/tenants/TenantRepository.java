package com.backend.webappserver.tenants;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TenantRepository extends CrudRepository<Tenant, String> {

	Tenant findByCompanyCode(String companyCode);


}
