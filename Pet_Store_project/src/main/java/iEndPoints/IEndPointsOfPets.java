package iEndPoints;

public interface IEndPointsOfPets {
	public static String uploadImagePost = "/pet/{petId}/uploadImage";
	public static String AddNewPetPost ="/pet";
	public static String UpdatePetPut ="/pet";
	public static String FindPetStatusGet ="/pet/findByStatus";
	public static String FindPetIDGet ="/pet/{petId}";
	public static String UpdatePetByIDPost ="/pet/{petId}";
	public static String deletePetByIDDelete ="/pet/{petId}";
}
