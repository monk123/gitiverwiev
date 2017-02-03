package by.ayupov.dao.impl;

import by.ayupov.entity.Role;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

@NoArgsConstructor
public class RoleDaoImpl extends BaseDaoImpl<Role> {
    private static final Logger log = Logger.getLogger(RoleDaoImpl.class);
    private static RoleDaoImpl roleDao;

    public static RoleDaoImpl getInstance() {
        if (roleDao == null) {
            roleDao = new RoleDaoImpl();
        }
        return roleDao;
    }
}
