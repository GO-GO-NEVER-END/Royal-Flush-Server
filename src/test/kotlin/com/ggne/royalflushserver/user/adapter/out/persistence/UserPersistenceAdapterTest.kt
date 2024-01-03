package com.ggne.royalflushserver.user.adapter.out.persistence

import com.ggne.royalflushserver.biz.user.adapter.out.persistence.UserPersistenceAdapter
import com.ggne.royalflushserver.biz.user.adapter.out.persistence.repository.UserRepository
import com.ggne.royalflushserver.biz.user.domain.model.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserPersistenceAdapterTest {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var userPersistenceAdapter: UserPersistenceAdapter

    private lateinit var user: User

    @BeforeEach
    fun setUp() {
        user = User(
            userId = "id",
            password = "password",
            name = "테스트",
            coin = 0,
            isSsamulie = false
        )
    }

    @Test
    fun `유저 insert 테스트`() {
        userPersistenceAdapter.saveUser(user)

        val result = userPersistenceAdapter.findUser("id")
        assertThat(result).isNotNull
    }

}