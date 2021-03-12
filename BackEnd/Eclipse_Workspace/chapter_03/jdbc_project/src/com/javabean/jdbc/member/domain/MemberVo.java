package com.javabean.jdbc.member.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * Member 테이블에 대응되는 엔티티(Entity) 자바빈(javabean)
 *  : VO(값 객체) : POJO(Plain Old Java Object) 형태
 *  : Plain => metadata(xml, annotaion 등)이 없이 순수하게 자바 코드만으로 구성
 *  : Old => EJB Entity
 * 
 * @author LimeParfait
 */

public class MemberVo implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String memberId;
    private String memberPassword;
    private String memberNickname;
    private String memberName;
    private String memberGender;
    private String memberEmail;
    private String memberPhone;
    private Date memberBirth;
    private String memberZip;
    private String memberAddressBasic;
    private String memberAddressDetail;
    private Date memberJoinDate;

    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getMemberPassword() {
        return memberPassword;
    }
    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }
    public String getMemberNickname() {
        return memberNickname;
    }
    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public String getMemberGender() {
        return memberGender;
    }
    public void setMemberGender(String memberGender) {
        this.memberGender = memberGender;
    }
    public String getMemberEmail() {
        return memberEmail;
    }
    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }
    public String getMemberPhone() {
        return memberPhone;
    }
    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }
    public Date getMemberBirth() {
        return memberBirth;
    }
    public void setMemberBirth(Date memberBirth) {
        this.memberBirth = memberBirth;
    }
    public String getMemberZip() {
        return memberZip;
    }
    public void setMemberZip(String memberZip) {
        this.memberZip = memberZip;
    }
    public String getMemberAddressBasic() {
        return memberAddressBasic;
    }
    public void setMemberAddressBasic(String memberAddressBasic) {
        this.memberAddressBasic = memberAddressBasic;
    }
    public String getMemberAddressDetail() {
        return memberAddressDetail;
    }
    public void setMemberAddressDetail(String memberAddressDetail) {
        this.memberAddressDetail = memberAddressDetail;
    }
    public Date getMemberJoinDate() {
        return memberJoinDate;
    }

    public void setMemberJoinDate(Date memberJoinDate) {
        this.memberJoinDate = memberJoinDate;
    }

    
    @Override
    public String toString() {
        return "MemberVo [memberAddressBasic=" + memberAddressBasic + ", memberAddressDetail=" + memberAddressDetail
                + ", memberBirth=" + memberBirth + ", memberEmail=" + memberEmail + ", memberGender=" + memberGender
                + ", memberId=" + memberId + ", memberJoinDate=" + memberJoinDate + ", memberName=" + memberName
                + ", memberNickname=" + memberNickname + ", memberPassword=" + memberPassword + ", memberPhone="
                + memberPhone + ", memberZip=" + memberZip + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((memberAddressBasic == null) ? 0 : memberAddressBasic.hashCode());
        result = prime * result + ((memberAddressDetail == null) ? 0 : memberAddressDetail.hashCode());
        result = prime * result + ((memberBirth == null) ? 0 : memberBirth.hashCode());
        result = prime * result + ((memberEmail == null) ? 0 : memberEmail.hashCode());
        result = prime * result + ((memberGender == null) ? 0 : memberGender.hashCode());
        result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
        result = prime * result + ((memberJoinDate == null) ? 0 : memberJoinDate.hashCode());
        result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
        result = prime * result + ((memberNickname == null) ? 0 : memberNickname.hashCode());
        result = prime * result + ((memberPassword == null) ? 0 : memberPassword.hashCode());
        result = prime * result + ((memberPhone == null) ? 0 : memberPhone.hashCode());
        result = prime * result + ((memberZip == null) ? 0 : memberZip.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MemberVo other = (MemberVo) obj;
        if (memberAddressBasic == null) {
            if (other.memberAddressBasic != null)
                return false;
        } else if (!memberAddressBasic.equals(other.memberAddressBasic))
            return false;
        if (memberAddressDetail == null) {
            if (other.memberAddressDetail != null)
                return false;
        } else if (!memberAddressDetail.equals(other.memberAddressDetail))
            return false;
        if (memberBirth == null) {
            if (other.memberBirth != null)
                return false;
        } else if (!memberBirth.equals(other.memberBirth))
            return false;
        if (memberEmail == null) {
            if (other.memberEmail != null)
                return false;
        } else if (!memberEmail.equals(other.memberEmail))
            return false;
        if (memberGender == null) {
            if (other.memberGender != null)
                return false;
        } else if (!memberGender.equals(other.memberGender))
            return false;
        if (memberId == null) {
            if (other.memberId != null)
                return false;
        } else if (!memberId.equals(other.memberId))
            return false;
        if (memberJoinDate == null) {
            if (other.memberJoinDate != null)
                return false;
        } else if (!memberJoinDate.equals(other.memberJoinDate))
            return false;
        if (memberName == null) {
            if (other.memberName != null)
                return false;
        } else if (!memberName.equals(other.memberName))
            return false;
        if (memberNickname == null) {
            if (other.memberNickname != null)
                return false;
        } else if (!memberNickname.equals(other.memberNickname))
            return false;
        if (memberPassword == null) {
            if (other.memberPassword != null)
                return false;
        } else if (!memberPassword.equals(other.memberPassword))
            return false;
        if (memberPhone == null) {
            if (other.memberPhone != null)
                return false;
        } else if (!memberPhone.equals(other.memberPhone))
            return false;
        if (memberZip == null) {
            if (other.memberZip != null)
                return false;
        } else if (!memberZip.equals(other.memberZip))
            return false;
        return true;
    }

    public MemberVo() {
    } 
    public MemberVo(String memberId, String memberPassword, String memberNickname, String memberName,
            String memberGender, String memberEmail, String memberPhone, Date memberBirth, String memberZip,
            String memberAddressBasic, String memberAddressDetail, Date memberJoinDate) {
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.memberNickname = memberNickname;
        this.memberName = memberName;
        this.memberGender = memberGender;
        this.memberEmail = memberEmail;
        this.memberPhone = memberPhone;
        this.memberBirth = memberBirth;
        this.memberZip = memberZip;
        this.memberAddressBasic = memberAddressBasic;
        this.memberAddressDetail = memberAddressDetail;
        this.memberJoinDate = memberJoinDate;
    }

}