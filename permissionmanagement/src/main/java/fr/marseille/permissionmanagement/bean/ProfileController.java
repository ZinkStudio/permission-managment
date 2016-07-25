package fr.marseille.permissionmanagement.bean;

import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import fr.marseille.permissionmanagement.exception.ServiceException;
import fr.marseille.permissionmanagement.model.Profile;
import fr.marseille.permissionmanagement.service.ProfileService;

@ManagedBean(name = "profileController")
@ApplicationScoped
public class ProfileController {

    private ProfileService profileService = new ProfileService();

    public List<Profile> findAll() throws ServiceException {
        return profileService.findAll();
    }

    public List<Profile> createProfiles() {
        return profileService.createProfiles();
    }

    public boolean save(Profile profile) throws ServiceException {
        return profileService.save(profile);
    }

    public void delete(Profile profile) throws ServiceException {
        profileService.delete(profile.getId());
    }

}
