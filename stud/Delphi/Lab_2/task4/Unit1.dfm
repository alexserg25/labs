object Form1: TForm1
  Left = 476
  Top = 108
  Width = 589
  Height = 188
  Caption = #1047#1072#1076#1072#1085#1080#1077' 4'
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -15
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  PixelsPerInch = 96
  TextHeight = 16
  object GroupBox1: TGroupBox
    Left = 8
    Top = 8
    Width = 217
    Height = 145
    Caption = #1042#1093#1086#1076#1085#1099#1077' '#1076#1072#1085#1085#1099#1077': '
    TabOrder = 0
    object Label1: TLabel
      Left = 8
      Top = 24
      Width = 77
      Height = 16
      Caption = #1042#1074#1077#1076#1080#1090#1077' Ax:'
    end
    object Label2: TLabel
      Left = 8
      Top = 48
      Width = 77
      Height = 16
      Caption = #1042#1074#1077#1076#1080#1090#1077' Bx:'
    end
    object Label3: TLabel
      Left = 8
      Top = 72
      Width = 77
      Height = 16
      Caption = #1042#1074#1077#1076#1080#1090#1077' Cx:'
    end
    object Label5: TLabel
      Left = 136
      Top = 24
      Width = 19
      Height = 16
      Caption = 'Ay:'
    end
    object Label6: TLabel
      Left = 136
      Top = 48
      Width = 19
      Height = 16
      Caption = 'By:'
    end
    object Label7: TLabel
      Left = 136
      Top = 76
      Width = 19
      Height = 16
      Caption = 'Cy:'
    end
    object eAx: TEdit
      Left = 88
      Top = 21
      Width = 41
      Height = 24
      TabOrder = 0
    end
    object eBx: TEdit
      Left = 88
      Top = 48
      Width = 41
      Height = 24
      TabOrder = 1
    end
    object eCx: TEdit
      Left = 88
      Top = 72
      Width = 41
      Height = 24
      TabOrder = 2
    end
    object eAy: TEdit
      Left = 160
      Top = 22
      Width = 41
      Height = 24
      TabOrder = 3
    end
    object eBy: TEdit
      Left = 160
      Top = 47
      Width = 41
      Height = 24
      TabOrder = 4
    end
    object eCy: TEdit
      Left = 160
      Top = 72
      Width = 41
      Height = 24
      TabOrder = 5
    end
  end
  object GroupBox2: TGroupBox
    Left = 232
    Top = 8
    Width = 337
    Height = 145
    Caption = #1042#1099#1093#1086#1076#1085#1099#1077' '#1076#1072#1085#1085#1099#1077': '
    TabOrder = 1
    object PTriangle: TLabel
      Left = 8
      Top = 40
      Width = 173
      Height = 16
      Caption = #1055#1077#1088#1080#1084#1077#1090#1088' '#1090#1088#1077#1091#1075#1086#1083#1100#1085#1080#1082#1072' = '
    end
    object Button1: TButton
      Left = 8
      Top = 104
      Width = 153
      Height = 25
      Caption = #1056#1072#1089#1089#1095#1080#1090#1072#1090#1100
      TabOrder = 0
      OnClick = Button1Click
    end
    object btnClose: TButton
      Left = 176
      Top = 104
      Width = 153
      Height = 25
      Caption = #1047#1072#1082#1088#1099#1090#1100
      TabOrder = 1
      OnClick = btnCloseClick
    end
  end
end
