/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaonline.loaders;

import com.tiendaonline.model.Album;

/**
 *
 * @author Rayco
 */
public interface ILoader {
    public Album loadAlbum(String id);
}
