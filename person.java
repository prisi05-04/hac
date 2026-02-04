public class Person {
    private String firstName;
    private String middleName;
    private String familyName;
    private String title;
    private String nickname;


    public Person(String firstName, String middleName, String familyName) {
        setFirstname(firstName);
        setmiddlename(middleName);
        setFamilyname(familyName);
        this.title = "family members";
        this.nickname = "joint family";
    }

    public void setFirstName(String firstName) {
        this.firstName = (firstName != null) ? firstName : "";
    }

    public void setMiddleName(String middleName) {
        this.middleName = (middleName != null) ? middleName : "";
    }

    public void setFamilyName(String familyName) {
        this.familyName = (familyName != null) ? familyName :"";
  }
   public void setTitle(String Title)
{
this.title=(title !=null)?title:"";
}
public void setnickName(String nickName)
{
this.nickname=(nickname !=null)? nickname :"";
}
public String getfirstname(string firstname)
{
return firstname;
}
public String Middlename(middlename)
{
return middlename;
}
public String getFamilyName() {
   return familyName;
}
public String getTitle() {
   return title;
}
public String getNickname() {
   return nickname;
}

    public String toString() {
        return familyName + ", " + firstName + " " + middleName;
    }

    public static void main(String[] args) {
        Person p = new Person("prisi", "santhan", "j");

    }