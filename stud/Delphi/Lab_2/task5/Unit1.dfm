object Form1: TForm1
  Left = 565
  Top = 168
  Width = 555
  Height = 188
  Caption = #1047#1072#1076#1072#1085#1080#1077' 5'
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -15
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  OnShow = FormShow
  PixelsPerInch = 96
  TextHeight = 16
  object GroupBox1: TGroupBox
    Left = 8
    Top = 8
    Width = 153
    Height = 145
    Caption = #1042#1093#1086#1076#1085#1099#1077' '#1076#1072#1085#1085#1099#1077': '
    TabOrder = 0
    object Label1: TLabel
      Left = 8
      Top = 24
      Width = 71
      Height = 16
      Caption = #1042#1074#1077#1076#1080#1090#1077' A:'
    end
    object Label2: TLabel
      Left = 8
      Top = 48
      Width = 71
      Height = 16
      Caption = #1042#1074#1077#1076#1080#1090#1077' B:'
    end
    object Label3: TLabel
      Left = 8
      Top = 72
      Width = 71
      Height = 16
      Caption = #1042#1074#1077#1076#1080#1090#1077' C:'
    end
    object eA: TEdit
      Left = 88
      Top = 21
      Width = 41
      Height = 24
      TabOrder = 0
      Text = '3,45'
    end
    object eB: TEdit
      Left = 88
      Top = 48
      Width = 41
      Height = 24
      TabOrder = 1
      Text = '5,6'
    end
    object eC: TEdit
      Left = 88
      Top = 72
      Width = 41
      Height = 24
      TabOrder = 2
      Text = '-4,5'
    end
  end
  object GroupBox2: TGroupBox
    Left = 168
    Top = 8
    Width = 369
    Height = 145
    Caption = #1042#1099#1093#1086#1076#1085#1099#1077' '#1076#1072#1085#1085#1099#1077': '
    TabOrder = 1
    object lblDiscriminant: TLabel
      Left = 8
      Top = 24
      Width = 108
      Height = 16
      Caption = #1044#1080#1089#1082#1088#1080#1084#1080#1085#1072#1085#1090' = '
    end
    object lblX1: TLabel
      Left = 8
      Top = 48
      Width = 28
      Height = 16
      Caption = 'X1 = '
    end
    object lblX2: TLabel
      Left = 8
      Top = 64
      Width = 28
      Height = 16
      Caption = 'X2 = '
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
      Left = 208
      Top = 104
      Width = 153
      Height = 25
      Caption = #1047#1072#1082#1088#1099#1090#1100
      TabOrder = 1
      OnClick = btnCloseClick
    end
  end
end
