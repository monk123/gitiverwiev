package by.ayupov.services.interfaces;

import by.ayupov.entity.Address;

import java.util.List;

public interface AddressService extends BaseService<Address> {

    /**
     * this method is needed to find city by user
     * @param name
     * @return
     */
    List<String> findCityByUser(String name);

    /**
     * this method is needed to find country by user
     * @param name
     * @return
     */
    List<String> findCountryByUser(String name);

    /**
     * this method is needed to find region by user
     * @param name
     * @return
     */
    List<String> findRegionByUser(String name);

    /**
     * this method is needed to find address by user
     * @param name
     * @return
     */
    public List<String> findAddressByUser(String name);

    /**
     * this method is needed to pagination address on page
     * @param pageNumber
     * @param page
     * @return
     */
    List<Address> paginationAddress(int pageNumber, int page);
}
