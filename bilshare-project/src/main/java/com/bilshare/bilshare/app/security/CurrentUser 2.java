package com.bilshare.bilshare.app.security;

import com.bilshare.bilshare.backend.data.entity.User;

@FunctionalInterface
public interface CurrentUser {

	User getUser();
}
