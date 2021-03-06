package com.jerotoma.services;

import java.util.List;

import com.jerotoma.model.ProductMedia;

public interface ProductMediaService {
	public ProductMedia getProductMedia(int id);
    public List<ProductMedia> getProductMediaList();
    public List<ProductMedia> getProductMediaList(int product_id);
    public ProductMedia update(ProductMedia productMedia);
    public int save(ProductMedia productMedia);
    public boolean delete(ProductMedia productMedia);
}
