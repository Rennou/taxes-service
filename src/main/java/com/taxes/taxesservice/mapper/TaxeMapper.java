package com.taxes.taxesservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", implementationPackage = "<PACKAGE_NAME>.generated")
public abstract  class TaxeMapper{

	    @Mapping(source = "id", target = "id")
		@Mapping(source = "dateTx", target = "dateTx")
		@Mapping(source = "taxFed", target = "taxFed")
	    @Mapping(source = "taxProv", target = "taxProv")
	    
	    
		public abstract com.taxes.model.Taxe toTaxe( com.taxes.taxesservice.model.Taxe taxe );

		//public abstract List<org.openapitools.client.model.Taxe>toTaxe(List<com.taxes.taxesservice.model.Taxe> taxeSource);
}