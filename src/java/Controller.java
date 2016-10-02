/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import EntityBeans.ResignationRequest;

import EntityBeans.Users;
import EntityBeans.Worker;
import com.mysql.jdbc.Connection;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.primefaces.event.FileUploadEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import query.ResignationRequestController;

import query.UsersController;
import query.WorkerController;
import query.exceptions.IllegalOrphanException;
import query.exceptions.NonexistentEntityException;

/**
 *
 * @author falbellaihi
 */
@ManagedBean
@SessionScoped
public class Controller {

    private String username; // variable to hold username input for log in check
    private String password;// variable to hold password input for log in check
    private int type = -10; // variable to check user type hence (manager, or other)

    private long userID; // variable to hold UID
    private Users fusername;

    private UsersController uController = new UsersController();
    private List<Users> usersList;

    private List<Users> userresult = new LinkedList(); // list used to hold user search results

    private String SU; // variable that is used to hold the input and search for it in a list hence (userresult list above)

    /* Request to resign*/
    private List<ResignationRequest> resignList; // resign list
    private ResignationRequestController rController = new ResignationRequestController(); // resign controller
    private String resignName;
    private String resignEmployeNum;
    private String resignNationalIDNum;
    private String ResignNotes;
    private int AutoAssignToIDNUM;

    /* end of request to resign*/
 /* Worker information : Government affairs and legal infromation for international workers */
    private List<Worker> workerList;
    private WorkerController wController = new WorkerController();

    /*End of Worker information :Government and legal infromation for international workers */
    /// New User Variables
    private String NewUsername; // variable to create new user name for new users
    private String NewPassword; // variable to hold password for new user
    private int NewType; // variable to hold the type of the new user
    private String NewEmail; // variable to hold the email of the new user
    private String NameOfUser; // variable to hold the legal name of the user
    private String PictureID = "Unknown"; // variable to hold the directory of the picture of the user
    private String PhoneNumber; // variable to hold the phone number of the user
    private String Employee_Num; // variable to hold the employee number of the user
    private int Permission_times; // variable to hold the times the user (employee has been excussed to leave things like sick leave or whatever)
    private String Comments; // variable to hold comment about the new user (employee)
    private int Vacation_Balance; // variable to hold the vacation balance for the user (employee)
    private String Salary; // variable to hold the user (employee) salary
// end of new user Variables

    //unsure variables
    private String newOtherN;
    private Users AssignUser;

    private String ForgotEmail;
    private String ForUser;

    private String returnPass;

    private Users SelectedUser;

    private Integer CurrentUID;

    private Users EditAssignUser;

    //end of unsure variables
    /* begain create new worker*/
    private String newWorkerName; // variable to hold the worker name
    private String newNationality; // variable to hold the worker nationality
    private String newResidenceCardNumber; // string to hold the resdence card number
    private String newPassportNumber; // string to hold the passport number of the worker
    private String newBankAccountNumber;  // string to hold the bank account number of the new worker
    private Date newResidenceCardExpiry; // variable to hold expiry date of the worker
    private Date newPassportExpiry;// variable to hold the passport expiry date 
    private String newPassportPic = "Unknown";// passport picture
    private String newResidencyCardPicture = "Unknown";//variable to hold the residency card picture path
    private String newWorkerPicture = "Unknown";// variable to hold the path of the worker pic 
    private String newOtherAttachments = "Unknown";// variable holds other attachments path
    /* end of new worker*/

 /*
    Begin worker updates comments and warnings
     */
    private String WarnWorkerUpdatesCommentPic;
    private String WarnWorkerUpdatesCommentCardPic;
    private String WarnWorkerUpdatesCommentPassportPic;
    private String WarnWorkerUpdatesCommentOtherAttachment;


    /*Eend of worker updates and warnings*/
 /* Profile variables */
    private int ProfileWorkerID; // varible to get worker ID number to set information in profile based on clicked worker
    private String ProfileWorkerName; // variable to hold the worker name in profile
    private String ProfileNationality; // variable to hold the worker nationality in profile
    private String ProfileResidenceCardNumber; // string to hold the resdence card number in profile
    private String ProfilePassportNumber; // string to hold the passport number of the worker in profile
    private String ProfileBankAccountNumber;  // string to hold the bank account number of the new worker in profile
    private Date ProfileResidenceCardExpiry; // variable to hold expiry date of the worker in profile
    private Date ProfilePassportExpiry;// variable to hold the passport expiry date in profile
    private String ProfilePassportPic = "Unknown";// passport picture in profile
    private String ProfileResidencyCardPicture = "Unknown";//variable to hold the residency card picture path in profile
    private String ProfileWorkerPicture = "Unknown";// variable to hold the path of the worker pic  in profile
    private String ProfileOtherAttachments = "Unknown";// variable holds other attachments path in profile

    // private List<Worker> workerProfileList = new LinkedList(); // list used to hold user search results
    /* end of profile varibles */
    /**
     * Creates a new instance of Controller
     */
    public Controller() {

    }

    public int getProfileWorkerID() {
        return ProfileWorkerID;
    }

    public void setProfileWorkerID(int ProfileWorkerID) {
        this.ProfileWorkerID = ProfileWorkerID;
    }

    public String getProfileWorkerName() {
        return ProfileWorkerName;
    }

    public void setProfileWorkerName(String ProfileWorkerName) {
        this.ProfileWorkerName = ProfileWorkerName;
    }

    public String getProfileNationality() {
        return ProfileNationality;
    }

    public void setProfileNationality(String ProfileNationality) {
        this.ProfileNationality = ProfileNationality;
    }

    public String getProfileResidenceCardNumber() {
        return ProfileResidenceCardNumber;
    }

    public void setProfileResidenceCardNumber(String ProfileResidenceCardNumber) {
        this.ProfileResidenceCardNumber = ProfileResidenceCardNumber;
    }

    public String getProfilePassportNumber() {
        return ProfilePassportNumber;
    }

    public void setProfilePassportNumber(String ProfilePassportNumber) {
        this.ProfilePassportNumber = ProfilePassportNumber;
    }

    public String getProfileBankAccountNumber() {
        return ProfileBankAccountNumber;
    }

    public void setProfileBankAccountNumber(String ProfileBankAccountNumber) {
        this.ProfileBankAccountNumber = ProfileBankAccountNumber;
    }

    public Date getProfileResidenceCardExpiry() {
        return ProfileResidenceCardExpiry;
    }

    public void setProfileResidenceCardExpiry(Date ProfileResidenceCardExpiry) {
        this.ProfileResidenceCardExpiry = ProfileResidenceCardExpiry;
    }

    public Date getProfilePassportExpiry() {
        return ProfilePassportExpiry;
    }

    public void setProfilePassportExpiry(Date ProfilePassportExpiry) {
        this.ProfilePassportExpiry = ProfilePassportExpiry;
    }

    public String getProfilePassportPic() {
        return ProfilePassportPic;
    }

    public void setProfilePassportPic(String ProfilePassportPic) {
        this.ProfilePassportPic = ProfilePassportPic;
    }

    public String getProfileResidencyCardPicture() {
        return ProfileResidencyCardPicture;
    }

    public void setProfileResidencyCardPicture(String ProfileResidencyCardPicture) {
        this.ProfileResidencyCardPicture = ProfileResidencyCardPicture;
    }

    public String getProfileWorkerPicture() {
        return ProfileWorkerPicture;
    }

    public void setProfileWorkerPicture(String ProfileWorkerPicture) {
        this.ProfileWorkerPicture = ProfileWorkerPicture;
    }

    public String getProfileOtherAttachments() {
        return ProfileOtherAttachments;
    }

    public void setProfileOtherAttachments(String ProfileOtherAttachments) {
        this.ProfileOtherAttachments = ProfileOtherAttachments;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }

    public Users getEditAssignUser() {
        return EditAssignUser;
    }

    public void setEditAssignUser(Users EditAssignUser) {
        this.EditAssignUser = EditAssignUser;
    }

    public Integer getCurrentUID() {
        return CurrentUID;
    }

    public void setCurrentUID(Integer CurrentUID) {
        this.CurrentUID = CurrentUID;
    }

    public List<ResignationRequest> getResignList() {
        return resignList;
    }

    public void setResignList(List<ResignationRequest> resignList) {
        this.resignList = resignList;
    }

    public String getResignName() {
        return resignName;
    }

    public void setResignName(String resignName) {
        this.resignName = resignName;
    }

    public String getResignEmployeNum() {
        return resignEmployeNum;
    }

    public void setResignEmployeNum(String resignEmployeNum) {
        this.resignEmployeNum = resignEmployeNum;
    }

    public String getResignNationalIDNum() {
        return resignNationalIDNum;
    }

    public void setResignNationalIDNum(String resignNationalIDNum) {
        this.resignNationalIDNum = resignNationalIDNum;
    }

    public String getResignNotes() {
        return ResignNotes;
    }

    public void setResignNotes(String ResignNotes) {
        this.ResignNotes = ResignNotes;
    }

    public int getAutoAssignToIDNUM() {
        return AutoAssignToIDNUM;
    }

    public void setAutoAssignToIDNUM(int AutoAssignToIDNUM) {
        this.AutoAssignToIDNUM = AutoAssignToIDNUM;
    }

    public String getEmployee_Num() {
        return Employee_Num;
    }

    public void setEmployee_Num(String Employee_Num) {
        this.Employee_Num = Employee_Num;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String Salary) {
        this.Salary = Salary;
    }

    public int getPermission_times() {
        return Permission_times;
    }

    public void setPermission_times(int Permission_times) {
        this.Permission_times = Permission_times;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    public int getVacation_Balance() {
        return Vacation_Balance;
    }

    public void setVacation_Balance(int Vacation_Balance) {
        this.Vacation_Balance = Vacation_Balance;
    }

    public String getForUser() {
        return ForUser;
    }

    public void setForUser(String ForUser) {
        this.ForUser = ForUser;
    }

    public String getForgotEmail() {
        return ForgotEmail;
    }

    public void setForgotEmail(String ForgotEmail) {
        this.ForgotEmail = ForgotEmail;
    }

    public Users getSelectedUser() {
        return SelectedUser;
    }

    public void setSelectedUser(Users SelectedUser) {
        this.SelectedUser = SelectedUser;
    }

    public String getWarnWorkerUpdatesCommentPic() {
        return WarnWorkerUpdatesCommentPic;
    }

    public void setWarnWorkerUpdatesCommentPic(String WarnWorkerUpdatesCommentPic) {
        this.WarnWorkerUpdatesCommentPic = WarnWorkerUpdatesCommentPic;
    }

    public String getWarnWorkerUpdatesCommentCardPic() {
        return WarnWorkerUpdatesCommentCardPic;
    }

    public String getWarnWorkerUpdatesCommentOtherAttachment() {
        return WarnWorkerUpdatesCommentOtherAttachment;
    }

    public void setWarnWorkerUpdatesCommentOtherAttachment(String WarnWorkerUpdatesCommentOtherAttachment) {
        this.WarnWorkerUpdatesCommentOtherAttachment = WarnWorkerUpdatesCommentOtherAttachment;
    }

    public void setWarnWorkerUpdatesCommentCardPic(String WarnWorkerUpdatesCommentCardPic) {
        this.WarnWorkerUpdatesCommentCardPic = WarnWorkerUpdatesCommentCardPic;
    }

    public String getWarnWorkerUpdatesCommentPassportPic() {
        return WarnWorkerUpdatesCommentPassportPic;
    }

    public void setWarnWorkerUpdatesCommentPassportPic(String WarnWorkerUpdatesCommentPassportPic) {
        this.WarnWorkerUpdatesCommentPassportPic = WarnWorkerUpdatesCommentPassportPic;
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");

        FacesContext.getCurrentInstance().addMessage(null, message);
        Path uploadFolder = Paths.get("D:\\wamp64/www");
        String fn = event.getFile().getFileName();
        int index = fn.indexOf(".");
        if (index < 0) {
            return;
        }
        String ext = fn.substring(index);
        String fileName = fn.substring(0, index);
        Path file = null;
        try {
            file = Files.createTempFile(uploadFolder, fileName, ext);
            InputStream input = event.getFile().getInputstream();
            Files.copy(input, file, StandardCopyOption.REPLACE_EXISTING);
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int userIndex = Integer.parseInt(event.getComponent().getAttributes().get("user").toString());
        SelectedUser = this.usersList.get(userIndex);
        SelectedUser.setPictureID("http://localhost/" + file.getFileName());
        System.out.println(SelectedUser.getPictureID());

    }

    public void handleExcleUpload() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = (Connection) DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "root"
        );
        Statement statement = connect.createStatement();
        ResultSet resultSet = statement
                .executeQuery("select * from emp_tbl");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook
                .createSheet("employe db");
        XSSFRow row = spreadsheet.createRow(1);
        XSSFCell cell;
        cell = row.createCell(1);
        cell.setCellValue("EMP ID");
        cell = row.createCell(2);
        cell.setCellValue("EMP NAME");
        cell = row.createCell(3);
        cell.setCellValue("DEG");
        cell = row.createCell(4);
        cell.setCellValue("SALARY");
        cell = row.createCell(5);
        cell.setCellValue("DEPT");
        int i = 2;
        while (resultSet.next()) {
            row = spreadsheet.createRow(i);
            cell = row.createCell(1);
            cell.setCellValue(resultSet.getInt("eid"));
            cell = row.createCell(2);
            cell.setCellValue(resultSet.getString("ename"));
            cell = row.createCell(3);
            cell.setCellValue(resultSet.getString("deg"));
            cell = row.createCell(4);
            cell.setCellValue(resultSet.getString("salary"));
            cell = row.createCell(5);
            cell.setCellValue(resultSet.getString("dept"));
            i++;
        }
        FileOutputStream out = new FileOutputStream(
                new File("exceldatabase.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println(
                "exceldatabase.xlsx written successfully");
    }

    public void h() {

        Users u = new Users();
        u = uController.findU(ForUser);

        System.out.println(u.getEmail());
        if (u.getEmail().equals(ForgotEmail)) {

            System.out.println("  Called email forgotpass ");
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("falbellaihi12345", "Faisal!1"));
            email.setSSLOnConnect(true);
            try {
                email.setFrom("falbellaihi12345@gmail.com");
                email.setSubject("Reset Plantalouge Password!");
                email.setMsg(u.getName() + " Hello!, Here is your login information " + u.getUsername() + " " + u.getPassword());
                email.addTo("falbellaihi@hotmail.com");
                email.send();
            } catch (EmailException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("Email not matched with user record");
        }
    } //forgot password function

    public Users getFusername() {
        return fusername;
    }

    public void setFusername(Users fusername) {
        this.fusername = fusername;
    }

    public List<Users> getUserresult() {
        return userresult;
    }

    public void setUserresult(List<Users> userresult) {
        this.userresult = userresult;
    }

    public String getSU() {
        return SU;
    }

    public void setSU(String SU) {
        this.SU = SU;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public void searchUser() {

        System.out.println("searching ...");

        userresult.clear();
        for (Users str : usersList) {
            if (str.toString().contains(SU)) {
                System.out.println(str);
                userresult.add(str);

            }
        }

        //return "Could not find plant";
    }

    public String getNewOtherN() {
        return newOtherN;
    }

    public void setNewOtherN(String newOtherN) {
        this.newOtherN = newOtherN;
    }

    public Users getAssignUser() {
        return AssignUser;
    }

    public void setAssignUser(Users AssignUser) {
        this.AssignUser = AssignUser;
    }

    public String getNameOfUser() {
        return NameOfUser;
    }

    public void setNameOfUser(String NameOfUser) {
        this.NameOfUser = NameOfUser;
    }

    public String getPictureID() {
        return PictureID;
    }

    public void setPictureID(String PictureID) {
        System.out.println("this is pic id" + PictureID);
        this.PictureID = PictureID;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getNewPassword() {
        return NewPassword;
    }

    public void setNewPassword(String NewPassword) {
        this.NewPassword = NewPassword;
    }

    public int getNewType() {
        return NewType;
    }

    public void setNewType(int NewType) {
        this.NewType = NewType;
    }

    public String getNewEmail() {
        return NewEmail;
    }

    public void setNewEmail(String NewEmail) {
        this.NewEmail = NewEmail;
    }

    public String getNewWorkerName() {
        return newWorkerName;
    }

    public void setNewWorkerName(String newWorkerName) {
        this.newWorkerName = newWorkerName;
    }

    public String getNewNationality() {
        return newNationality;
    }

    public void setNewNationality(String newNationality) {
        this.newNationality = newNationality;
    }

    public String getNewResidenceCardNumber() {
        return newResidenceCardNumber;
    }

    public void setNewResidenceCardNumber(String newResidenceCardNumber) {
        this.newResidenceCardNumber = newResidenceCardNumber;
    }

    public String getNewPassportNumber() {
        return newPassportNumber;
    }

    public void setNewPassportNumber(String newPassportNumber) {
        this.newPassportNumber = newPassportNumber;
    }

    public String getNewBankAccountNumber() {
        return newBankAccountNumber;
    }

    public void setNewBankAccountNumber(String newBankAccountNumber) {
        this.newBankAccountNumber = newBankAccountNumber;
    }

    public Date getNewResidenceCardExpiry() {
        return newResidenceCardExpiry;
    }

    public void setNewResidenceCardExpiry(Date newResidenceCardExpiry) {
        this.newResidenceCardExpiry = newResidenceCardExpiry;
    }

    public Date getNewPassportExpiry() {
        return newPassportExpiry;
    }

    public void setNewPassportExpiry(Date newPassportExpiry) {
        this.newPassportExpiry = newPassportExpiry;
    }

    public String getNewPassportPic() {
        return newPassportPic;
    }

    public void setNewPassportPic(String newPassportPic) {
        this.newPassportPic = newPassportPic;
    }

    public String getNewResidencyCardPicture() {
        return newResidencyCardPicture;
    }

    public void setNewResidencyCardPicture(String newResidencyCardPicture) {
        this.newResidencyCardPicture = newResidencyCardPicture;
    }

    public String getNewWorkerPicture() {
        return newWorkerPicture;
    }

    public void setNewWorkerPicture(String newWorkerPicture) {
        this.newWorkerPicture = newWorkerPicture;
    }

    public String getNewOtherAttachments() {
        return newOtherAttachments;
    }

    public void setNewOtherAttachments(String newOtherAttachments) {
        this.newOtherAttachments = newOtherAttachments;
    }

    public void getUsernameByID(int ID, int index) {

        //Here where to get UID and return the username;
    }

    public void removePlant(int ID, int index) {

    }

    public void removeUser(int ID, int index) throws IllegalOrphanException {
        try {
            uController.destroy(ID);
            usersList.remove(index);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeWork(int ID, int index) {

    }

    public void removeResign(int ID, int index) {

        System.out.println("remove resign" + ID);
        try {
            System.out.println("remove resign");
            rController.destroy(ID);
            resignList.remove(index);
        } catch (NonexistentEntityException ex) {
            ex.printStackTrace();;
        }
    }

    public String getNewUsername() {
        return NewUsername;
    }

    public void setNewUsername(String NewUser) {
        this.NewUsername = NewUser;
    }

    public void createUser() {
        System.out.println("called create user");
        try {
            Users newUser = new Users();
            newUser.setUsername(NewUsername);
            newUser.setPassword(NewPassword);
            newUser.setType(NewType);
            newUser.setEmail(NewEmail);
            newUser.setPhone(PhoneNumber);
            PictureID = "Unknown";
            newUser.setPictureID(PictureID);
            newUser.setName(NameOfUser);
            newUser.setEmployenum(Employee_Num);
            newUser.setLeavePermissiontimes(Permission_times);
            newUser.setVacationBalance(Vacation_Balance);
            newUser.setNotes(Comments);
            newUser.setSalary(Salary);

            uController.create(newUser);

            usersList = uController.findUsersEntities(); //retrieves all the users from the database

        } catch (Exception ex) {
            StackTraceElement[] stackTrace = ex.getStackTrace();
        }

    }

    public void createProfile(Worker w) {

        System.out.println(w.getWorkerName());

    }

    public void createWorker() { //creates new worker
        workerList = wController.findWorkerEntities();
        /*
        creates new worker
         */
        Worker newWorker = new Worker();
        newWorker.setWorkerName(newWorkerName);
        newWorker.setNationality(newNationality);
        newWorker.setResidenceCardNumber(newResidenceCardNumber);
        newWorker.setPassportNumber(newPassportNumber);
        newWorker.setResidenceCardExpiry(newResidenceCardExpiry);
        newWorker.setPassportExpiry(newPassportExpiry);
        newWorker.setBankAccountNumber(newBankAccountNumber);
        newWorker.setPassportPicture(newPassportPic);
        newWorker.setResidencyCardPicture(newResidencyCardPicture);
        newWorker.setOtherAttachment(newOtherAttachments);
        newWorker.setWorkerPicture(newWorkerPicture);

        for (Worker s : workerList) { // find if there is dublicated worker
            // if (s.toString().) {
            //  System.out.println(newWorkerName + "  ;;Already in system");
            //}
            // else {
            //   System.out.println("  -> " + s.toString());
            // }
        }

        wController.create(newWorker);

        workerList = wController.findWorkerEntities();

    }

    public void createWorkerProfile(Worker workerInfo, int index) {

        System.out.println(" " + workerInfo.getId() + " " + index);
        ProfileWorkerID = workerInfo.getId();
        ProfileWorkerName = workerInfo.getWorkerName();
        ProfileNationality = workerInfo.getNationality();
        ProfileResidenceCardNumber = workerInfo.getResidenceCardNumber();
        ProfilePassportNumber = workerInfo.getPassportNumber();
        ProfileBankAccountNumber = workerInfo.getBankAccountNumber();
        ProfileResidenceCardExpiry = workerInfo.getResidenceCardExpiry();
        ProfilePassportExpiry = workerInfo.getPassportExpiry();
        ProfilePassportPic = workerInfo.getPassportPicture();
        ProfileResidencyCardPicture = workerInfo.getResidencyCardPicture();
        ProfileWorkerPicture = workerInfo.getWorkerPicture();
        ProfileOtherAttachments = workerInfo.getOtherAttachment();

    }

    public void createResignRequest() {

        System.out.println("createResignRequest");
        ResignationRequest newResign = new ResignationRequest();

        newResign.setName(resignName);
        newResign.setEmployeeNum(resignEmployeNum);
        newResign.setNationalID(resignNationalIDNum);

        newResign.setNotes(ResignNotes);

        newResign.setUserID(AssignUser);

        rController.create(newResign);
        resignList = rController.findResignationRequestEntities(); //retrieves all the resigns from the database

    }

    public String getReturnPass() {
        return returnPass;
    }

    public void setReturnPass(String returnPass) {
        this.returnPass = returnPass;
    }

    public void editUser(Users u) {

        try {
            //Object newValue = event.getNewValue();

            // Plants plant = pController.findPlants(ID);
            uController.edit(u);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void editRequestStep(ResignationRequest r) {

        System.out.println("Edit resign " + EditAssignUser + "   this is userthig" + r.getName());

        try {
            System.out.println("Edit resign");
            r.setUserID(EditAssignUser);
            rController.edit(r);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getType(int t) {
        switch (t) {
            case 0:
                return "مدير";
            case 1:
                return "اداري";
            case 2:
                return "موظف";

        }
        return "Unknown";
    }

    public String login() {

        usersList = uController.findUsersEntities(); //retrieves all the users from the database
        resignList = rController.findResignationRequestEntities(); //retrieves all the resigns from the database
        workerList = wController.findWorkerEntities(); // to fetch worker information and insert it into the list
        Users user = uController.login(username, password, type);

        CurrentUID = user.getId();

        System.out.println("\n\n\n test test " + username + " -- " + password + "user id is " + user.getId());
        if (user == null) {
            return null;

        } else {
            System.out.println("\n\n\n test test ");

            switch (type) {
                case 0:

                    return "ControlPanel.xhtml";
                case 1:
                    return "StudentControlPanel.xhtml";
                case 2:
                    return "dontatorHome.xhtml";

                default:
                    return "ControlPanel.xhtml";
            }

        }
    }

    public void WarnWorkerUpdates(Worker workerUpdates) {

        workerList = wController.findWorkerEntities();
        System.out.println(wController.findWorker(workerUpdates.getId()).getPassportPicture());
        if (wController.findWorker(workerUpdates.getId()).getWorkerPicture().equals("Unknown")
                || wController.findWorker(workerUpdates.getId()).getPassportPicture().equals("Unknown")
                || wController.findWorker(workerUpdates.getId()).getResidencyCardPicture().equals("Unknown")
                || wController.findWorker(workerUpdates.getId()).getOtherAttachment().equals("Unknown")) {

            WarnWorkerUpdatesCommentPic = "صورة العامل لم ترفع بعد";
            WarnWorkerUpdatesCommentCardPic = " صورة بطاقة الأقامة لم ترفع بعد";
            WarnWorkerUpdatesCommentPassportPic = "صورة الجواز لم ترفع بعد";
            WarnWorkerUpdatesCommentOtherAttachment = "لم يتم ارفاق مرفقات اخر لهذا العامل ";

        } else {

            WarnWorkerUpdatesCommentPic = "لاتوجد تنبيهات";// notfity the user that everything is okay!
            WarnWorkerUpdatesCommentCardPic = ""; //clear variable if already uploaded a picture
            WarnWorkerUpdatesCommentPassportPic = ""; // clear the variable if already uploaded picture
            WarnWorkerUpdatesCommentOtherAttachment = ""; //clear the variable if already uploaded a picture

        }

    }

    public void accessUserInfo() {

        usersList = uController.findUsersEntities(); //retrieves all the users from the database

    }

    public void FetchWorkerInfo() {

        workerList = wController.findWorkerEntities();

    }

    public String logout() {
        System.out.println("bye ");
        username = null;
        password = null;
        type = -10;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml";

    }

}