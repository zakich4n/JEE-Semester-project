package project.spotEEfy.core.service;

import project.spotEEfy.core.dao.CommentDAO;
import project.spotEEfy.core.dao.LikeDAO;

import javax.inject.Named;
import javax.transaction.Transactional;


@Named
@Transactional
public class LikeService {
    private LikeDAO likeDAO;

    public LikeService(LikeDAO likeDAO){
        this.likeDAO = likeDAO;
    }



}
