package client.controllers;

import client.ClientMain;
import client.model.ConvertImage;
import client.model.entity.UserEntity;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FriendController implements Initializable {

    @FXML
    private Label id_text;

    @FXML
    private Label postNumber_text;

    @FXML
    private ImageView profilePic;

    private UserEntity friendObject;
    private AnchorPane anchorPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setData(UserEntity user, AnchorPane anchorPane) {
        this.anchorPane =anchorPane;
        this.friendObject = user;
        this.id_text.setText(user.getUserName());
        this.postNumber_text.setText(ClientMain.formatDate(user.getDateJoin()));
        this.profilePic.setImage(ConvertImage.getProfile(user));
    }


    public void onFriendClicked(MouseEvent mouseEvent) {
        ProfileScreenController profileScreen = (ProfileScreenController) ClientMain.loadUI("ProfileScreen", anchorPane);
        profileScreen.setupUser(LoginController.getUserEntity(),friendObject);
    }


}
